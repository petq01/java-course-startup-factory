package org.startupfactory.javacourse.designpatters.pool;

import java.util.ArrayList;
import java.util.List;

public class Pool {
	private List<DataClass> instancesList;
	private int maxInstancesInPool;

	public Pool(int maxInstancesInPool) {
		this.maxInstancesInPool = maxInstancesInPool;
		createPool();
	}

	private void createPool() {
		DataClass data;
		instancesList = new ArrayList<DataClass>(maxInstancesInPool);
		for (int i = 0; i < maxInstancesInPool; i++) {
			data = new DataClass();
			instancesList.add(data);

		}
	}

	public <E> E acquire() throws PoolException {
		Object object;
		if (instancesList.isEmpty()) {
			throw new PoolException("Pool is empty");
		} else {
			System.out.println("Object " + instancesList.size() + " acquired...");
			object = (Object) instancesList.remove(instancesList.size() - 1);
		}
		return (E) object;
	}

	public void release(DataClass data) throws PoolException {
		if (instancesList.size() == maxInstancesInPool) {
			throw new PoolException("Pool is full");
		} else {
			instancesList.add(data);
			System.out.println("Object " + instancesList.size() + " released...");
		}
	}
}
