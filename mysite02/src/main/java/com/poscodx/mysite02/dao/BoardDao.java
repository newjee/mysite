package com.poscodx.mysite02.dao;

import com.poscodx.mysite02.vo.BoardVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    public void increaseHit(Long no) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "UPDATE board SET hit = hit + 1 WHERE no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, no);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Long getMaxGNo() {
        BoardVo vo = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            // 가장 큰 gNo 값을 가져오는 SQL 쿼리
            String sql = "select MAX(g_no) from board";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Long maxGNo = rs.getLong(1);

                vo = new BoardVo();
                vo.setMaxGNo(maxGNo);
            }

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vo.getMaxGNo();
    }


    public void update(BoardVo vo) {
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();

            String sql = "UPDATE board SET o_no = ? WHERE g_no = ? AND o_no >= ?";
            pstmt = conn.prepareStatement(sql);

            System.out.println();
            System.out.println("update전" + vo);
            pstmt.setLong(1, vo.getoNo());
            pstmt.setLong(2, vo.getgNo());
            pstmt.setLong(3, vo.getoNo());

            System.out.println("update전" + pstmt);
//                pstmt1.setString(4, vo.getUserPassword());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Boolean insert(BoardVo vo) {
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            System.out.println("insert" + vo);

            String sql = "insert into board values(null, ?, ?, ?, now(), ?, ?, ?, ? )";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContents());
            pstmt.setLong(3, vo.getHit());
            pstmt.setLong(4, vo.getgNo());

            if (vo.getMaxGNo() != null) {
                pstmt.setLong(5, vo.getoNo());
                pstmt.setLong(6, vo.getDepth());
            } else {
                pstmt.setLong(5, vo.getoNo() + 1);
                pstmt.setLong(6, vo.getDepth() + 1);
            }
            pstmt.setLong(7, vo.getUserNo());
            int count = pstmt.executeUpdate();
            System.out.println("insert" + pstmt);

            //5. 결과 처리
            result = count == 1;

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public BoardVo findByNo(Long no) {
        BoardVo vo = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String sql =
                    "select a.no, a.title, a.contents, a.hit, date_format(a.reg_date, '%Y/%m/%d %H:%i:%s')" +
                            ", a.g_no, a.o_no, a.depth, b.name" +
                            "      from board a, user b" +
                            "      where a.user_no = b.no" +
                            "       and a.no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, no);

            rs = pstmt.executeQuery();

            // 결과처리 -> 한줄이면 if, 여러줄이면 while
            if (rs.next()) {
                String title = rs.getString(2);
                String contents = rs.getString(3);
                Long hit = rs.getLong(4);
                String regDate = rs.getString(5);
                Long gNo = rs.getLong(6);
                Long oNo = rs.getLong(7);
                Long depth = rs.getLong(8);
                String name = rs.getString(9);

                vo = new BoardVo();
                vo.setNo(no);
                vo.setTitle(title);
                vo.setContents(contents);
                vo.setHit(hit);
                vo.setRegDate(regDate);
                vo.setgNo(gNo);
                vo.setoNo(oNo);
                vo.setDepth(depth);
                vo.setName(name);

            }

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vo;
    }


    public Boolean deleteByNoAndPassword(Long no) {
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "delete from board where no = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, no);

            int count = pstmt.executeUpdate();

            result = count == 1;
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//        System.out.println(result);
        return result;
    }


    public BoardVo pageCnt(String kwd) {
        BoardVo vo = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String sql =
                    "    select count(no) from board " +
                            "  where title like ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kwd );

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Long pageCnt = rs.getLong(1);

                vo = new BoardVo();
                vo.setPageCnt(pageCnt);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vo;
    }

    public List<BoardVo> findAll(Long page, String kwd) {
        List<BoardVo> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String sql =
                    "    select a.no, a.title, a.contents, a.hit, date_format(a.reg_date, '%Y/%m/%d %H:%i:%s')" +
                            ", a.g_no, a.o_no, a.depth, b.name" +
                            "      from board a, user b" +
                            "      where a.user_no = b.no" +
                            "      and a.title like ?" +
                            "  order by g_no desc, o_no asc" +
                            "  limit ?, 5";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kwd );
            pstmt.setLong(2, (page - 1) * 5);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Long no = rs.getLong(1);
                String title = rs.getString(2);
                String contents = rs.getString(3);
                Long hit = rs.getLong(4);
                String regDate = rs.getString(5);
                Long gNo = rs.getLong(6);
                Long oNo = rs.getLong(7);
                Long depth = rs.getLong(8);
                String name = rs.getString(9);


                BoardVo vo = new BoardVo();
                vo.setNo(no);
                vo.setTitle(title);
                vo.setContents(contents);
                vo.setHit(hit);
                vo.setRegDate(regDate);
                vo.setgNo(gNo);
                vo.setoNo(oNo);
                vo.setDepth(depth);
                vo.setName(name);

                result.add(vo);
            }

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public void modifyUpdate(BoardVo vo) {
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();

            String sql = "UPDATE board SET title = ? , contents =? WHERE no = ? ";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContents());
            pstmt.setLong(3, vo.getNo());

            System.out.println(pstmt);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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