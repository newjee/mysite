package com.poscodx.mysite02.vo;

public class BoardVo {

    private Long no;
    private String title;
    private String contents;
    private Long hit;
    private String regDate;
    private Long gNo;
    private Long oNo;
    private Long depth;
    private String name;
    private Long userNo;
    private Long pageCnt;
    private Long MaxGNo;
    private String kwd;

    @Override
    public String toString() {
        return "BoardVo{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", hit=" + hit +
                ", regDate='" + regDate + '\'' +
                ", gNo=" + gNo +
                ", oNo=" + oNo +
                ", depth=" + depth +
                ", name='" + name + '\'' +
                ", userNo=" + userNo +
                ", pageCnt=" + pageCnt +
                ", MaxGNo=" + MaxGNo +
                ", kwd='" + kwd + '\'' +
                '}';
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Long getHit() {
        return hit;
    }

    public void setHit(Long hit) {
        this.hit = hit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Long getgNo() {
        return gNo;
    }

    public void setgNo(Long gNo) {
        this.gNo = gNo;
    }

    public Long getoNo() {
        return oNo;
    }

    public void setoNo(Long oNo) {
        this.oNo = oNo;
    }

    public Long getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserNo() {
        return userNo;
    }

    public Long getPageCnt() {
        return pageCnt;
    }

    public Long getMaxGNo() {
        return MaxGNo;
    }

    public void setMaxGNo(Long maxGNo) {
        MaxGNo = maxGNo;
    }

    public void setPageCnt(Long pageCnt) {
        this.pageCnt = pageCnt;
    }

    public String getKwd() {
        return kwd;
    }

    public void setKwd(String kwd) {
        this.kwd = kwd;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }
}

