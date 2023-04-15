package db;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MemberService {
    public List<Member> list(){
        List<Member> memberList = new ArrayList<Member>();

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet rs = null;

        String memberTypeValues = "email";
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select member_type, user_id, password, name " +
                    "from member " +
                    "where member_type = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValues);
            //preparedStatement.setString(2, userIdValue);

            rs = preparedStatement.executeQuery();
            while(rs.next()){
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                Member member = new Member();
                member.setMemberType(memberTypeValues);
                member.setUserId(userId);
                member.setPassword(password);
                member.setName(name);
                
                memberList.add(member);
                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
        return memberList;
    }
    
    public Member detail(String memberType, String userId){
        Member member = null;

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select m.member_type, m.user_id, m.password, m.name, md.mobile_no, md.marketing_yn, md.register_date "
            		+ " from member m "
            		+ " left join member_detail md on md.member_type = m.member_type and m.user_id = md.user_id "
            		+ " where m.member_type = ? and m.user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberType);
            preparedStatement.setString(2, userId);

            //preparedStatement.setString(2, userIdValue);

            rs = preparedStatement.executeQuery();
            if(rs.next()){
            	member = new Member();
                member.setMemberType(rs.getString("member_type"));
                member.setUserId(rs.getString("user_id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setMobile(rs.getString("mobile_no"));
                member.setMarketing_yn(rs.getBoolean("marketing_yn"));
                member.setRegisterDate(rs.getDate("register_date"));



            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
        return member;
    }

    // 회원가입 함수
    /*
    @param member 회원정보

     */
    public void register(Member member){

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet rs = null;


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "insert into member (member_type, user_id, password, name) values (? , ?, ?, ?); ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    public void dbUpdate(){

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet rs = null;

        String memberTypeValues = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";
        String nameValue = "제로베이스";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "update member set " +
                    " password = ? " +
                    " where member_type = ? and user_id = ? ";

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValues);
            preparedStatement.setString(3, userIdValue);

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    public void withdraw(Member member){

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " delete from member " +
                    "where member_type = ? and user_id= ? ";

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

}
