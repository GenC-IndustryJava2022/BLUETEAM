export class ActiveProduct {
  constructor(
    public activeProductsId: number,
    public productId: number,
    public cartId: number,
    public quantity: number
  ) {}
}
