package com.fiap.tc2sub.Biblioteca.model.livro;

import java.util.List;

/**
 * The type Page.
 *
 * @param <T> the type parameter
 */
public class Page<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;


    /**
     * Instantiates a new Page.
     *
     * @param content       the content
     * @param pageNumber    the page number
     * @param pageSize      the page size
     * @param totalElements the total elements
     */
    public Page(List<T> content, int pageNumber, int pageSize, long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / pageSize);
    }

    /**
     * Gets total pages.
     *
     * @return the total pages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * Gets page number.
     *
     * @return the page number
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Gets total elements.
     *
     * @return the total elements
     */
    public long getTotalElements() {
        return totalElements;
    }
}