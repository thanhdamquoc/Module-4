package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.IBlogComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    @Query(value = "select blog.*, category.name as categoryName, count(comment.blog_id) as commentCount from blog left join comment on blog.id = comment.blog_id left join category on blog.category_id = category.id group by blog.id, blog.date order by blog.date desc;", nativeQuery = true)
    Iterable<IBlogComment> getBlogAndComment();
}
