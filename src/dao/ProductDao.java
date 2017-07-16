package dao;

import java.util.List;

import entity.TProduct;

public interface ProductDao<T> {
	/**
	 * 查找所有的项目
	 * 
	 * @param t
	 *            需要查找的entity，这里需要传entity
	 * @return
	 */
	public List<T> findAllItem(T t);

	/**
	 * 根据商品的id获取商品的数据库记录
	 * 
	 * @param t
	 *            需要查询的实体类
	 * @param id
	 *            查询的id
	 * @return
	 */
	public T getById(T t, int id);

	/**
	 * 分页查询
	 * 
	 * @param t
	 *            需要查询的实体类
	 * @param startPage
	 *            开始查询的起始页数，如第1页，则传1进去，第2页传2进去
	 * @param maxResult
	 *            每页最大记录数
	 * @return
	 */
	public List<T> getByPage(T t, int startPage, int maxResult);

	/**
	 * 根据商品的标签返回商品列表，很明确的是根据查询条件查询数据库，因此至少有一个标签，hot,bigTypeId,smallTypeId或specialPrice
	 * 
	 * @param product
	 *            传递数据的对象
	 * @param start
	 *            查询的开始
	 * @param maxResult
	 *            每次查询最大记录数
	 * @return
	 */
	public List<TProduct> getByTags(TProduct product, int start, int maxResult);
}
