import request from '@/utils/request'

// 查询客户信息管理列表
export function listMall_user(query) {
  return request({
    url: '/system/mall_user/list',
    method: 'get',
    params: query
  })
}

// 查询客户信息管理详细
export function getMall_user(id) {
  return request({
    url: '/system/mall_user/' + id,
    method: 'get'
  })
}

// 新增客户信息管理
export function addMall_user(data) {
  return request({
    url: '/system/mall_user',
    method: 'post',
    data: data
  })
}

// 修改客户信息管理
export function updateMall_user(data) {
  return request({
    url: '/system/mall_user',
    method: 'put',
    data: data
  })
}

// 删除客户信息管理
export function delMall_user(id) {
  return request({
    url: '/system/mall_user/' + id,
    method: 'delete'
  })
}
