public class BinaryHeap {

	private int[] HeapData;
	private int size;

	public BinaryHeap() {
		HeapData = new int[10];
		size = 0;
	}

	//Helper functions
	private int leftchild(int pos) {
		return 2*pos + 1;
	}

	private int rightchild(int pos) {
		return 2*pos + 2;
	}

	private int parent(int pos) {
		return ((pos-1) / 2);
	}

	private void swap(int pos1, int pos2) {
		int tmp = HeapData[pos1];
		HeapData[pos1] = HeapData[pos2];
		HeapData[pos2] = tmp;
	}

	public void add(int elem) {
		if (HeapData.length == size) {
			grow_heap();
		}
		int current = size;
		HeapData[size++] = elem;

		while (HeapData[current] < HeapData[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void grow_heap() {
		int[] newHeapData = new int[size*2];
		for (int i = 0; i < size; i++) {
			newHeapData[i] = HeapData[i];
		}
		HeapData = newHeapData;
	}

	public int remove() {
		int priority = HeapData[0];
		swap(0, --size);
		if (size != 0) {
			siftdown(0);
		}
		return priority;
	}

	private void siftdown(int position) {
		int smallestchild = leftchild(position);
		if (smallestchild >= size) {
			return;
		}
		if (rightchild(position) < size && HeapData[rightchild(position)] < HeapData[smallestchild]) {
			smallestchild = rightchild(position);
		}
		if (HeapData[smallestchild] < HeapData[position]) {
			swap(smallestchild, position);
			siftdown(smallestchild);
		}
	}


}