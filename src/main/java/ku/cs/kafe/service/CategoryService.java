package ku.cs.kafe.service;

import ku.cs.kafe.entity.Category;
import ku.cs.kafe.model.CategoryRequest;
import ku.cs.kafe.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void createCategory(CategoryRequest request) {
        Category record = modelMapper.map(request, Category.class);
        categoryRepository.save(record);
    }
}
