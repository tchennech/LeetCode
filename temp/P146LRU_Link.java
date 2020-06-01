// 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
// 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

// 你是否可以在 O(1) 时间复杂度内完成这两种操作？

// 双向链表和Map
class LRUCache {
  class LinkedTabel {
    int key;
    int val;
    LinkedTabel next;
    LinkedTabel pre;

    LinkedTabel(int key, int val) {
      this.key = key;
      this.val = val;
    }

    LinkedTabel() {
    }
  }

  int capacity;
  int count;
  LinkedTabel head;
  LinkedTabel back;
  Map<Integer, LinkedTabel> pos;

  public LRUCache(int capacity) {
    count = 0;
    this.capacity = capacity;
    pos = new HashMap<>();
    head = new LinkedTabel();
    back = new LinkedTabel();
    head.next = back;
    back.pre = head;
  }

  public int get(int key) {
    if (!pos.containsKey(key)) {
      return -1;
    }
    LinkedTabel node = pos.get(key);
    node.next.pre = node.pre;
    node.pre.next = node.next;
    moveToHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (pos.containsKey(key)) {
      LinkedTabel t = pos.get(key);
      t.val = value;
      t.pre.next = t.next;
      t.next.pre = t.pre;
      moveToHead(t);
      return;
    }
    if (count == capacity) {
      LinkedTabel del = back.pre;
      del.pre.next = back;
      back.pre = del.pre;
      pos.remove(del.key);
      count--;
    }
    LinkedTabel a = new LinkedTabel(key, value);
    moveToHead(a);
    pos.put(key, a);
    count++;
  }

  public void moveToHead(LinkedTabel node) {
    node.next = head.next;
    node.next.pre = node;
    node.pre = head;
    head.next = node;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */