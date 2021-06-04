package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select count(t) from Task t where t.status = 0")
	Integer nTasksPublic();
	
	@Query("select count(t) from Task t where t.status = 1")
	Integer nTasksPrivate();
	
	@Query("select count(t) from Task t where t.finishMoment >= ?1")
	Integer findTaskNonFinished(Date nonFinished);
	
	@Query("select count(t) from Task t where t.finishMoment < ?1")
	Integer findTaskFinished(Date finished);

	@Query("select avg(workload) from Task")
	Double averageTaskWorkload();
	
	@Query("select min(workload) from Task")
	Integer minTaskWorkload();
	
	@Query("select max(workload) from Task")
	Integer maxTaskWorkload();

	@Query("select STDDEV(workload) from Task")
	Double stdevpTaskWorkload();
	
	
	//
	
	
	@Query("select avg(DATEDIFF(finishMoment, startMoment)) FROM Task")
	Double averageTaskExecutionPeriod();
	
	@Query("select min(DATEDIFF(finishMoment, startMoment)) FROM Task")
	Integer minTaskExecutionPeriod();
	
	@Query("select max(DATEDIFF(finishMoment, startMoment)) FROM Task")
	Integer maxTaskExecutionPeriod();

	@Query("select STDDEV(DATEDIFF(finishMoment, startMoment)) FROM Task")
	Double stdevpTaskExecutionPeriod();
	
	//
	
	@Query("select count(x) FROM Shout x where x.xxx.flag = 0")
	Integer nShoutNoPublic();
	
	@Query("select count(x) FROM Shout x where x.xxx.flag = 1")
	Integer nShoutPublic();

	@Query("select avg(amount.amount) FROM XXX where  amount.currency = 'EUR' ")
	Double averageShoutaverageEur();
	
	@Query("select STDDEV(amount.amount) FROM XXX where  amount.currency = 'EUR'")
	Double stdevpShoutaverageEur();
	
	@Query("select avg(amount.amount) FROM XXX where  amount.currency = 'USD' ")
	Double averageShoutaverageUSD();
	
	@Query("select STDDEV(amount.amount) FROM XXX where  amount.currency = 'USD'")
	Double stdevpShoutaverageUSD();
}
