# API Documentation

## Overview
This document provides details about the RESTful APIs available for managing barang (items).

Base URL: `http://example.com/api`

## Barang Endpoints

### Retrieve All Barang

```
GET /barang
```

Retrieve a list of all barang.

#### Response

| Status Code | Description     | Body                      |
|-------------|-----------------|---------------------------|
| 200         | OK              | List of Barang objects    |
| 404         | Not Found       | -                         |

### Retrieve Barang by Name

```
GET /barang/nama/{namaBarang}
```

Retrieve a single barang by its name.

#### Parameters

- `namaBarang`: The name of the barang to retrieve.

#### Response

| Status Code | Description     | Body              |
|-------------|-----------------|-------------------|
| 200         | OK              | Barang object     |
| 404         | Not Found       | -                 |

### Add New Barang

```
POST /barang
```

Add a new barang.

#### Request Body

```json
{
  "nama": "Nama Barang",
  "harga": 10000,
  "jumlah": 5
}
```

#### Response

| Status Code | Description     | Body          |
|-------------|-----------------|---------------|
| 201         | Created         | Barang object |
| 400         | Bad Request     | -             |

### Update Barang

```
PUT /barang/{namaBarang}
```

Update an existing barang.

#### Parameters

- `namaBarang`: The name of the barang to update.

#### Request Body

```json
{
  "nama": "Nama Barang",
  "harga": 15000,
  "jumlah": 8
}
```

#### Response

| Status Code | Description     | Body          |
|-------------|-----------------|---------------|
| 200         | OK              | Barang object |
| 404         | Not Found       | -             |

### Delete Barang

```
DELETE /barang/{namaBarang}
```

Delete a barang by its name.

#### Parameters

- `namaBarang`: The name of the barang to delete.

#### Response

| Status Code | Description     | Body          |
|-------------|-----------------|---------------|
| 200         | OK              | Success message |
| 404         | Not Found       | -             |
