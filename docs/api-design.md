# ShopAPI - Thiết kế API

Base URL: `/api/v1`

## Category

| Method | Path             | Mô tả                | Request         | Response           | Status                | Quyền  |
|--------|------------------|----------------------|-----------------|--------------------|-----------------------|--------|
| GET    | /categories      | Danh sách category   | -               | CategoryResponse[] | 200                   | Public |
| GET    | /categories/{id} | Category theo id     | -               | CategoryResponse   | 200, 404              | Public |
| POST   | /categories      | Tạo mới category     | CategoryRequest | CategoryResponse   | 201, 400, 409(trùng)  | Admin  |
| PUT    | /categories/{id} | Cập nhật category    | CategoryRequest | CategoryResponse   | 200, 400, 404, 409    | Admin  |
| DELETE | /categories/{id} | Xóa Category theo id | -               | -                  | 204, 404, 409(còn sp) | Admin  |

## Product
``` Base product URL: /products ```

| Method | Path         | Mô tả             | Request                                                          | Response              | Status                                  | Quyền  |
|--------|--------------|-------------------|------------------------------------------------------------------|-----------------------|-----------------------------------------|--------|
| GET    |              | Danh sách product | Query: keyword, categoryId, minPrice, maxPrice, page, size, sort | Page<ProductResponse> | 200                                     | Public |
| GET    | /{id}        | Product theo id   | -                                                                | ProductDetailResponse | 200, 404                                | Public |
| POST   |              | Tạo mới           | {name, description, price, stock, categoryId}                    | ProductResponse       | 201, 400, 404(không tồn tại categoryId) | ADMIN  |
| PUT    | /{id}        | Cập nhật toàn bộ  | {name, description, price, stock, categoryId}                    | ProductResponse       | 200, 400, 404                           | ADMIN  |
| PATCH  | /{id}        | Cập nhật 1 phần   | field cần thay đổi                                               | ProductResponse       | 200, 400, 404                           | ADMIN  |
| DELETE | /{id}        | Xóa               | -                                                                | -                     | 204, 404                                | ADMIN  |
| POST   | /{id}/images | Ảnh sản phẩm      | multipart/form-data                                              | ImageResponse         | 201, 404                                | ADMIN  |

## Cart
``` Base cart URL: /cart ```

| Method | Path               | Mô tả                                      | Request               | Response     | Status                         | Quyền |
|--------|--------------------|--------------------------------------------|-----------------------|--------------|--------------------------------|-------|
| GET    |                    | Xem giỏ hàng                               | -                     | CartResponse | 200                            | USER  |
| POST   | /items             | Thêm sản phẩm. Đã có thì cộng dồn số lượng | {productId, quantity} | CartResponse | 200, 400, 404,409(Quá tồn kho) | USER  |
| PATCH  | /items/{productId} | Đổi số lượng                               | {quantity}            | CartResponse | 200, 400, 404, 409             | USER  |
| DELETE | /items/{productId} | Xóa 1 sản phẩm khỏi giỏ                    | -                     | -            | 204, 404                       | USER  |
| DELETE |                    | Xóa toàn bộ sản phẩm khỏi giỏ              |                       |              | 204                            | USER  |

## Order
``` Base order URL: /orders ```

| Method | Path           | Mô tả                                            | Request                                   | Response                   | Status                                     | Quyền       |
|--------|----------------|--------------------------------------------------|-------------------------------------------|----------------------------|--------------------------------------------|-------------|
| GET    |                | Danh sách đơn hàng (USER: của mình, ADMIN: all ) | Query: status, page, size, sort           | Page<OrderSummaryResponse> | 200                                        | USER, ADMIN |
| GET    | /{id}          | Chi tiết đơn hàng                                | -                                         | OrderResponse              | 200, 404 (Kể cả đơn của người khác)        | USER, ADMIN |
| POST   |                | Đặt từ giỏ hàng                                  | { shippingAddress, phone, paymentMethod } | OrderResponse              | 201, 400 (giỏ trống), 409 (hết hàng)       | USER        |
| POST   | /{id}/cancel   | Huỷ đơn                                          | {reason}                                  | OrderResponse              | 200, 404, 409 (Đang hoặc đã giao)          | USER, ADMIN |
| POST   | /{id}/payments | Thanh toán đơn                                   | {method}                                  | PaymentResponse            | 201, 404, 409 (đã thanh toán)              | USER        |
| PATCH  | /{id}/status   | Chuyển trạng thái đơn hàng                       | {status}                                  | OrderResponse              | 200, 400, 404, 409( chuyển trạng thái sai) | ADMIN       |
