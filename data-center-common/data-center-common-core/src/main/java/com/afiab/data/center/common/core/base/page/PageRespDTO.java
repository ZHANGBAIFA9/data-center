package com.afiab.data.center.common.core.base.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 16:45
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRespDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总数
     */
    private Integer totalCount;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 数据
     */
    private T list ;

    public PageRespDTO(Integer totalCount, Integer pageSize, T list){
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPage = (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    public static <T> PageRespDTOBuilder<T> builder() {
        return new PageRespDTOBuilder();
    }

    public static class PageRespDTOBuilder<T> {
        private Integer totalCount;
        private Integer pageSize;
        private Integer totalPage;
        private T list;

        PageRespDTOBuilder() {
        }


        // Integer totalCount, Integer pageSize, T list
        public PageRespDTOBuilder<T> page(Integer totalCount, Integer pageSize, T list) {
            this.totalCount = totalCount;
            this.pageSize = pageSize;
            this.totalPage = (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
            this.list = list;
            return this;
        }

        public PageRespDTO<T> build() {
            return new PageRespDTO(this.totalCount, this.pageSize, this.totalPage, this.list);
        }

        @Override
        public String toString() {
            return "PageRespDTO.PageRespDTOBuilder(totalCount=" + this.totalCount + ", pageSize=" + this.pageSize + ", totalPage=" + this.totalPage + ", list=" + this.list + ")";
        }
    }
}
