package org.example.resevationsystem.service;

import java.util.List;
import java.util.Optional;

import org.example.resevationsystem.entity.Product;
import org.example.resevationsystem.repository.JpaProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final JpaProductRepository repository;

	/**
	 * Productオブジェクトの全件取得
	 * @return
	 */
	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	/**
	 * 指定idに該当する商品を1件取得
	 * @param id
	 * @return
	 */
	@Override
	public Optional<Product> getProductsByIds(Long id) {
		return repository.findById(id);
	}

	/**
	 * 指定したidの商品を更新する
	 * @param id 商品id
	 * @param productDetails inputした商品オブジェクト
	 * @return Productオブジェクト
	 */
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

	/**
	 * 指定idに該当する商品を1件取得
	 * @param id 商品id
	 * @return Productオブジェクト
	 */
	@Override
	public Product getProductById(Long id) {
		return repository.findById(id).orElse(null);
	}

	

	

	
	
}
