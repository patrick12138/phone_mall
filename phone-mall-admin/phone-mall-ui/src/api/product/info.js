import request from '@/utils/request'

// 查询商品信息列表
export function listInfo(query) {
  return request({
    url: '/product/info/list',
    method: 'get',
    params: query
  })
}

// 查询商品信息详细
export function getInfo(skuId) {
  return request({
    url: '/product/info/' + skuId,
    method: 'get'
  })
}

// 新增商品信息
export function addInfo(data) {
  return request({
    url: '/product/info',
    method: 'post',
    data: data
  })
}

// 修改商品信息
export function updateInfo(data) {
  return request({
    url: '/product/info',
    method: 'put',
    data: data
  })
}

// 删除商品信息
export function delInfo(skuId) {
  return request({
    url: '/product/info/' + skuId,
    method: 'delete'
  })
}
