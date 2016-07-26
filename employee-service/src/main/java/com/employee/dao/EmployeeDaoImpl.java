package com.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired 
	protected SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployess() throws Exception {
		return getCurrentSession().createCriteria(Employee.class).addOrder( Order.asc("id") ).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployeesbyPage(Long pageNumber) throws Exception {
		
		Long pgNumber=5*(pageNumber-1);		
		return getCurrentSession().createCriteria(Employee.class).addOrder( Order.asc("id") ).add(Restrictions.ge("id",pgNumber)).setMaxResults(5).list();
	}

	@Override
	public Employee getEmployeeById(Long id) throws Exception{
		return (Employee) getCurrentSession().get(Employee.class, id);
		}

	@Override
	public Employee updateEmployee(Employee employee) throws Exception{
		return (Employee)getCurrentSession().merge(employee);
	}

	@Override
	public void deleteEmployee(Long id) throws Exception{
		
		Employee e = (Employee) getCurrentSession().get(Employee.class, id);
		
		if(e!=null)
		  getCurrentSession().delete(e);
		
	}

	@Override
	@Transactional(readOnly=false,propagation = Propagation.REQUIRES_NEW )
	public Employee createEmployee(Employee employee) {
	 
			return (Employee)getCurrentSession().merge(employee);
		}	

	@Override
	@Transactional(readOnly=false,propagation = Propagation.REQUIRES_NEW )
	public List<Employee> getunEmployed() {
		
		Criteria criteria = getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employed", false));
		criteria.addOrder( Order.asc("id") );
		
		return (List<Employee>)criteria.setMaxResults(5).list();
		}	

	
}
