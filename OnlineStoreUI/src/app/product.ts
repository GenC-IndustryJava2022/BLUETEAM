export class Product {
  constructor(
    public productId: number,
    public name: string,
    public price: number,
    public image: string,
    public description: string,
    public categoryId: number
  ) {}
}
