// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
/*
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer
        .orders
        .filter(Order::isDelivered)
        .flatMap(Order::products)
        .maxBy(Product::price)
}*/

fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer
        .orders
        .filter { it.isDelivered }
        .flatMap { it.products }
        .maxBy { it.price }

    //val allProducts = customer.getOrderedProducts()
    //return allProducts.sortedBy { it.price }.component1()
}


// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
        .flatMap (Customer :: getOrderedProducts)
        .count { it == product }

}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }
