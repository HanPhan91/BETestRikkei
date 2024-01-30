package com.test.service.category;

import com.test.exception.UnauthorizedException;
import com.test.model.Category;
import com.test.model.dto.CategoryCreateReqDTO;
import com.test.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllByDeletedIsFalse() {
        return categoryRepository.getAllByDeletedIsFalse();
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category create(CategoryCreateReqDTO categoryCreateReqDTO) {

        Boolean existsTitle = categoryRepository.existsByTitle(categoryCreateReqDTO.getTitle());

        if (existsTitle) {
            throw new UnauthorizedException("Tiêu đề danh mục đã tồn tại");
        }

        Category category = categoryCreateReqDTO.toCategory();

        return categoryRepository.save(category);
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
