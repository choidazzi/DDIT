package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import kr.or.ddit.vo.FileInfoVO;

public interface IFileInfoService {
			
		/**
		 * fileVo에 담겨진 자료를 DB에 insert하는 메서드
		 * 
		 * @param fileVo DB에 insert할 자료가 저장된 FileInfoVO객체
		 * @return 작업성공 : 1, 작업 실패 : 0
		 */
		public int insertFileinfo(FileInfoVO fileVo);
		
		
		/**
		 * 전체 파일 정보 목록을 가져와 List에 담아서 반환하는 메서드
		 * 
		 * @return 파일 정보 목록이 저장된 List객체
		 */
		public List<FileInfoVO> getAllFileinfo();
		
		/**
		 * fileNo를 매개변수로 받아서 해당 파일 정보를 변환하는 메서드
		 * 
		 * @param fileNo 검색할 파일 번호
		 * @return 검색될 파일 정보가 저장된 FileInfoVo객체
		 */
		public FileInfoVO getFileinfo(int fileNo);
	
}
