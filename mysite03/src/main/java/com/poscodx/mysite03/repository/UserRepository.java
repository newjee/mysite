package com.poscodx.mysite03.repository;

import com.poscodx.mysite03.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void update(UserVo vo) {
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = getConnection();
            if (vo.getPassword().equals("")) {
                String sql1 = "UPDATE user SET name = ?, gender = ? " +
                        "WHERE email = ?";
                pstmt1 = conn.prepareStatement(sql1);


                System.out.println(vo);
                pstmt1.setString(1, vo.getName());
                pstmt1.setString(2, vo.getGender());
                pstmt1.setString(3, vo.getEmail());
                System.out.println(pstmt1);
//                pstmt1.setString(4, vo.getUserPassword());

                pstmt1.executeUpdate();


            }
             else {
                String sql2 = "UPDATE user SET name = ?, password = SHA2(?,'256'), gender = ? " +
                        "WHERE email = ? ";
                pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, vo.getName());
                pstmt2.setString(2, vo.getPassword());
                pstmt2.setString(3, vo.getGender());
                pstmt2.setString(4, vo.getEmail());
//                pstmt2.setString(5, vo.getUserPassword());

                pstmt2.executeUpdate();

            }


        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if(pstmt1 != null) {
                    pstmt1.close();
                }
                if(pstmt2 != null) {
                    pstmt2.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Boolean insert(UserVo vo) {
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "insert into user values(null, ?, ?, SHA2(?,'256'), ?, current_date())";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getEmail());
            pstmt.setString(3, vo.getPassword());
            pstmt.setString(4, vo.getGender());

            int count = pstmt.executeUpdate();

            //5. 결과 처리
            result = count == 1;

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public UserVo findAll(Long no, String name) {

        UserVo vo =  null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String sql =
                    "    select no, name, email, gender" +
                            "      from user" +
                            "  where no = ? and name =? ";
            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, no);
            pstmt.setString(2, name);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                vo = new UserVo();
                vo.setNo(rs.getLong(1));
                vo.setName(rs.getString(2));
                vo.setEmail(rs.getString(3));
                vo.setGender(rs.getString(4));

            }


        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }

                if(pstmt != null) {
                    pstmt.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vo;
    }

    public UserVo findByEmailAndPassword(String email, String password) {
        UserVo userVo = null;
        List<UserVo> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String sql =
                    "    select no, name " +
                            "      from user " +
                            "where email = ? and password = SHA2(?,'256')";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);


            rs = pstmt.executeQuery();

            // 결과처리 -> 한줄이면 if, 여러줄이면 while
            if(rs.next()) {
                Long no = rs.getLong(1);
                String name = rs.getString(2);

                userVo = new UserVo();
                userVo.setNo(no);
                userVo.setName(name);
            }

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }

                if(pstmt != null) {
                    pstmt.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userVo;
    }


    private Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            String url = "jdbc:mariadb://localhost:3306/shopping_db?charset=utf8";
            conn = DriverManager.getConnection(url, "shopping", "shopping");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패:" + e);
        }

        return conn;
    }
}