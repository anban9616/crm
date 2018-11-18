package zhku.zhou.crm.service.customer;

public interface Parent<T> {
	public int addOne(T record);
	public int deleteOne(int id);
	public int updateOne(T record);
	public T selectOne(int id);
}
