# Java-Test
测试用

### 验证返回值：

验证a和b的值是否相等

```$xslt
assertEquals(a, b);
```

### 验证某个方法是否被调用

> verify(mock, times(1)).setTips(tips);

1. times的参数表示调用次数，默认是1。times(1)可以省略；
2. 验证 mock.setTips(tips) 是否被调用；
3. 对私有方法无效；

```$xslt
@Test
public void testSetTips() throws Exception {
    // mock这个类，这个套路是固定的。
    PrintIn mock = mock(PrintIn.class);
    // 变量
    String tips = "tips";
    // 调用方法赋值
    mock.setTips(tips);
    // 验证这个方法，是否被调用成功（次数是1）
    verify(mock, times(1)).setTips(tips);
}
```

###



### 超时测试

> @Test(timeout = 100)

预期该函数的执行时间是 100ms，如果超出这个时间则报错；