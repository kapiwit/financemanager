package category;

import income.Income;
import income.IncomeDTO;

import java.util.List;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public void showAll() {
        CategoryDao.showAll();
    }
    public void remove(int id) {
        categoryDao.delete(id);
    }
    public void add(CategoryDTO categoryDTO) {
        if (categoryDTO.getCategory() != null ) {
            Category category = new Category(categoryDTO.getCategory());
            categoryDao.insert(category);
        } else {
            throw new IllegalArgumentException("Błędne dane");
        }
    }
    public List<Category> showByCategory(int id){
        return categoryDao.showByCategory(id);
    }
}