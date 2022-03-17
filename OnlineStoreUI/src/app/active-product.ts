export class ActiveProduct {
  constructor(
    public id: number,
    public productId: number,
    public cartId: number,
    public quantity: number
  ) {}
}
