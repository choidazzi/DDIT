package chapter08;

public class DaoExample {
	//DAO : Data Access Object => 데이터에 접근하는 객체
	//=> iBatis or myBatis => orm framework
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
//		dbWork(new DataAccessObject()) ; 사용불가 
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}
}