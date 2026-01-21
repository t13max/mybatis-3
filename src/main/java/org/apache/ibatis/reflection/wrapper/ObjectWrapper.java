/*
 *    Copyright 2009-2025 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.wrapper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map.Entry;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * 对象包装器接口
 *
 * @author Clinton Begin
 */
public interface ObjectWrapper {

  //获取属性值
  Object get(PropertyTokenizer prop);

  //设置属性值
  void set(PropertyTokenizer prop, Object value);

  //获取属性值
  String findProperty(String name, boolean useCamelCaseMapping);

  //获取所有的setter方法名
  String[] getGetterNames();

  //获取所有的getter方法名
  String[] getSetterNames();

  //获取setter方法的参数类型
  Class<?> getSetterType(String name);

  //获取getter方法的返回值类型
  Class<?> getGetterType(String name);

  //获取泛型setter方法的参数类型
  default Entry<Type, Class<?>> getGenericSetterType(String name) {
    throw new UnsupportedOperationException("'" + this.getClass() + "' must override the default method 'getGenericSetterType()'.");
  }

  //获取泛型getter方法的返回值类型
  default Entry<Type, Class<?>> getGenericGetterType(String name) {
    throw new UnsupportedOperationException("'" + this.getClass() + "' must override the default method 'getGenericGetterType()'.");
  }

  //是否有setter方法
  boolean hasSetter(String name);

  //是否有getter方法
  boolean hasGetter(String name);

  //实例化属性值
  MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

  //是否为集合对象
  boolean isCollection();

  //添加元素到集合中
  void add(Object element);

  //添加多个元素到集合中
  <E> void addAll(List<E> element);

}
