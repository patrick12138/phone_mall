import request from '@/utils/request'

// 查询商品图片列表
export function listImages(query) {
  return request({
    url: '/product/images/list',
    method: 'get',
    params: query
  })
}

// 查询商品图片详细
export function getImages(id) {
  return request({
    url: '/product/images/' + id,
    method: 'get'
  })
}

// 新增商品图片
export function addImages(data) {
  return request({
    url: '/product/images',
    method: 'post',
    data: data
  })
}

// 修改商品图片
export function updateImages(data) {
  return request({
    url: '/product/images',
    method: 'put',
    data: data
  })
}

// 删除商品图片
export function delImages(id) {
  return request({
    url: '/product/images/' + id,
    method: 'delete'
  })
}
