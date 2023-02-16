# ₿ ORIL-CRIPTO-PARSER ₿

<p align="center">
  <a href="#description">Description</a> •
  <a href="#structure">Structure</a> •
  <a href="#used-technologies">Used technologies</a> •
  <a href="#endpoints">Endpoints</a> •
  <a href="#how-to-use">How To Use</a> •
</p>

## Description

This small web API is a test task, which is based on a demonstration of receiving price for the following pairs: BTC/USD, ETH/USD and XRP/USD using CEX.IO REST API every 10 seconds, as well as working with a NoSQL database for saving and generating various types of data retrieval processing requests.

## Structure
#### This web application structure is N-tier architecture model that including the following layers:
- Controllers
- Service
- Model
- DAO (CRUD operations)
- DTO


## Used technologies

- Java 11
- MongoDB
- Spring Boot, Spring Data

## Endpoints

<table>
<thead>
<tr>
<th>Method</th>
<th align="center">Endpoint</th>
<th align="center">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>GET</td>
<td>/cryptocurrencies/minprice?name=[currency_name]</td>
<td>return record with the lowest price of selected cryptocurrency</td>
</tr>
<tr>
<td>GET</td>
<td>/cryptocurrencies/maxprice?name=[currency_name]</td>
<td>return record with the highest price of selected cryptocurrency</td>
</tr>
<tr>
<td>GET</td>
<td>/cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size]</td>
<td>return a selected page with selected number of elements and default sorting should be by price from lowest to highest. For example, if page=0&size=10, then you should return first 10 elements from database, sorted by price from lowest to highest. [page_number] and [page_size] request parameters should be optional, so if they are missing then you should set them default values page=0, size=10.</td>
</tr>
<tr>
<td>GET</td>
<td>/cryptocurrencies/csv</td>
<td>Saving Saving received data to a cvs file. File contain the following fields: Cryptocurrency Name, Min Price, Max Price.</td>
</tr>
</tbody>
</table>

> **Note**
> [currency_name] possible values: BTC, ETH or XRP. If some other value is provided then appropriate error message should be thrown.

## How To Use

- Clone this project.
- Install MongoDB.
- Run.
- Enjoy.
