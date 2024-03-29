package org.example.resevationsystem.service.implement;

import java.util.List;
import java.util.Optional;

import org.example.resevationsystem.entity.Product;
import org.example.resevationsystem.repository.JpaProductRepository;
import org.example.resevationsystem.service.spec.ProductService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final JpaProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Product> getProductsByIds(Long id) {
		return repository.findById(id);
	}

	@Override
	public Product updateProduct(Long id, Product productDetails) {
		Product product = repository.findById(id)
							.orElseThrow(() -> new RuntimeException("Product not found with id"));
		
		//商品の詳細を更新
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductStock(productDetails.getProductStock());
		
		// 更新された商品をデータベースに保存
		return repository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return repository.findById(id).orElse(null);
	}

}
