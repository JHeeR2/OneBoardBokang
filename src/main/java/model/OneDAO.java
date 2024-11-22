package model;

import java.util.ArrayList;

public class OneDAO extends JDBConnect {
	
	//디폴트 생성자를 통해 DB 연결이 완료된다. 
	public OneDAO() {
		super();
	}

	//입력을 위한 메서드 - 입력, 수정 삭제 int, select... 등 arraylist
	//요청 서블릿이 받고 이후 디비는 DAO가
	public int writeInsert(OneDTO oneDTO) {
		int result = 0;
		String query = "insert into tb (subject) values (?)";
		try {
			//동적쿼리 실행을 위해 인스턴스 생성
			psmt = con.prepareStatement(query);
			//사용자가 입력한 값으로 인파라미터 생성
			psmt.setString(1, oneDTO.getSubject());
			//쿼리실행, insert 이므로 성공한 행의 갯수 반환됨
			result = psmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력실패");
			
		}
		//입력성공이면 1, 실패면 0 반환
		return result;
		
	}
	
	
	//목록 출력을 위한 메서드
	public ArrayList<OneDTO> listSelect() {
		//OneDTO 인스턴스를 저장할 수 있는 리스트 생성
		ArrayList<OneDTO> ones = new ArrayList<OneDTO>();
		//select 쿼리문 작성
		String query ="select * from tb "
				+ " order by "
				+ " subject desc";
		try {
			//쿼리문을 인자로 preparedStatement 인스턴스 생성
			psmt = con.prepareStatement(query);
			//쿼리문 실행 및 결과 레코드 반환
			rs = psmt.executeQuery();
			while(rs.next()) {
				OneDTO oneDTO = new OneDTO();
				//DTO에 컬럼을 지정하여 레코드 저장
				oneDTO.setSubject(rs.getString("subject"));
				
				//리스트.add
				ones.add(oneDTO);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("목록 조회시 에러발생");
		}
		
		//목록에 출력할 레코드가 저장된 List를 컨트롤러로 반환
		return ones;
	}
	
	
	//삭제를 위한 메서드
	public int deletePost(String subj) {
		int result = 0;
		String query = "delete from tb where subject =?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, subj);
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	//기존 내용을 불러오기 위한 메서드
	public OneDTO loadSelect(String subj) {
		String query = "select * from tb where subject= ? ";
		OneDTO oneDTO = new OneDTO();
		try {
			//기존 내용을 인출해서 DTO에 저장 후 반환한다 
			psmt = con.prepareStatement(query);
			psmt.setString(1, subj);
			rs = psmt.executeQuery();
			if(rs.next()) {
				oneDTO.setSubject(rs.getString("subject"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시물 로드 시 에러발생");
		}
		
		return oneDTO;
		
	}
	
	//수정을 위한 메서드 정의
	public int editUpdate(OneDTO oneDTO) {		
		String query ="update tb set subject= ? "
				+ " where subject= ? ";
		int result = 0 ;
		try {
			psmt = con.prepareStatement(query);
			//실제 수정할 내용
			psmt.setString(1, oneDTO.getSubject());
			//조건절에 사용할 내용
			psmt.setString(2, oneDTO.getPrev_subj());
			//실행
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 중 에러발생");
		}
		
		return result;
		
	}
	
	
	
	
}
