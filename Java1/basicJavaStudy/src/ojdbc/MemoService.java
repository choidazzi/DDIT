package ojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemoService {
    private MemoDAO dao = new MemoDAO();
	public List<MemoVO> getMemos() throws Exception {
		return dao.getMemos();
	}

	public MemoVO getMemo(int searchId) throws Exception {
		return dao.getMemo(searchId);
	}

	public int insertMemo(MemoVO vo) throws Exception {
		return dao.insertMemo(vo);
	}

	public int updateMemo(MemoVO vo) {
		return dao.updateMemo(vo);
	}

	// delete from memo where id = ?
	public int deleteMemo(int deleteId) {
		return dao.deleteMemo(deleteId);
	}
}
