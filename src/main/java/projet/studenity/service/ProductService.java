package projet.studenity.service;

import projet.studenity.model.Cart;
import projet.studenity.model.Product;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ProductService {
    public abstract boolean createProduct(Product product);
    public abstract boolean updateProduct(Product product);
    public abstract boolean deleteProduct(int id);
    public abstract List<Product> getProducts();
    public Product findProductById(int id);
    public List<Product> findProductByName(String firstName);
    public boolean reserveProduct(int id);
    public List<Product> findProductByCategory(int idCategory);
    public List<Product> listProductByUser(int idUser);
    public List<Product> findProductByFilter(int idCategory, int statusCode, int availability, int startDate) throws ParseException;
}
