<template>
  <div class="backs fill-height">
    <v-container justify-center fluid fill-height>
      <v-row justify="center">
        <v-col cols="6">
          <h1 class="text-center pb-2">Welcome to Sales Management page</h1>
          <v-divider></v-divider>
          <v-card>
            <v-tabs
              color="deep-purple accent-4"
              background-color="primary"
              left
              v-model="tab3"
            >
              <v-tab class="white--text">Create New Sale</v-tab>
              <v-tab class="white--text">View Sales</v-tab>
              <v-tab class="white--text">Edit Sales</v-tab>
              <!-- <v-tab-items> -->
              <v-tab-item>
                <v-card class="mx-auto elevation-12">
                  <v-card-text>
                    <h3>Let's sell something</h3>
                    <v-form
                      v-for="(product, n) in sale.products" :key="n"
                      v-model="valid"
                      lazy-validation
                      ref="form"
                      class="pt-6 px-7"
                    >
                      <h4 class="pb-5">transaction # {{ n }}</h4>

                      <v-row>
                        <v-col cols="3">
                          <v-select
                            outlined
                            :items="products"
                            item-text="title"
                            name="Productname"
                            label="Product name "
                            type="text"
                            v-model="sale.products[n]"
                            :rules="productRules"
                            required
                            return-object
                          ></v-select>
                        </v-col>
                        <v-col cols="3">
                          <v-text-field
                            outlined
                            label="Quantities "
                            type="number"
                            v-model="sale.products[n].quantity"
                            :rules="quantitiesRules"
                            required
                          ></v-text-field>
                        </v-col>

                        <v-col cols="2">
                          <v-text-field
                            :value="sale.products[n].quantity * sale.products[n].price"
                            outlined
                            readonly
                            name="Totals"
                            label="Total"
                            type="number"
                          ></v-text-field>
                        </v-col>
                      </v-row>
                      <v-divider class="pb-3"></v-divider>
                    </v-form>

                    <v-row>
                      <v-col cols="5">
                        <v-btn color="success" @click="sale.products.push({
          id: '',
          price: 10,
          quantity: 1,
        })">
                          Add another product
                        </v-btn>
                      </v-col>
                      <v-col cols="2">
                        <v-text-field
                          outlined
                          readonly
                          name="Total"
                          label="Total"
                          type="number"
                          v-model="sale.total"
                        ></v-text-field>
                      </v-col>
                      <v-col cols="3">
                        <v-select
                          outlined
                          :items="clients"
                          item-text="name"
                          item-value="id"
                          name="Clientname"
                          label="Client name "
                          type="text"
                          v-model="sale.client_name"
                          required
                          :rules="clientRules"
                        ></v-select>
                      </v-col>
                      <v-col cols="2">
                        <v-text-field
                          outlined
                          name="Seller"
                          label="Seller"
                          type="text"
                          counter="20"
                          v-model="sale.seller_name"
                          :rules="sellerRules"
                          required
                        ></v-text-field>
                      </v-col>
                    </v-row>
                  </v-card-text>
                  <v-card-actions class="flex-column">
                    <v-spacer></v-spacer>
                    <v-btn
                      :disabled="!valid"
                      class="mr-4"
                      @click="validate"
                      color="primary"
                    >
                      Sell
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <v-card class="mx-auto elevation-12 midcard Blured">
                  <v-card-text class="pa-12">
                    <v-form ref="reset" class="pb-16 px-7">
                      <v-container
                        class="cont"
                        d-flex
                        flex-column
                        flex-direction:
                        row
                      >
                        <h3>Choose sale to view :</h3>
                        <v-select
                          class="pr-16 pl-1"
                          :items="sales"
                          solo
                          label=""
                          ref="reset"
                          v-model="sale.name"
                        ></v-select>
                        <p>Sale id {{ sale.id.toString() }}</p>
                      </v-container>
                      <v-text-field
                        outlined
                        disabled
                        name="Sales"
                        label="Sale"
                        type="text"
                        v-model="sale.name"
                      ></v-text-field>
                      <v-textarea
                        outlined
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="sale.description"
                        disabled
                      ></v-textarea>
                      <v-text-field
                        outlined
                        disabled
                        name="Category"
                        label="Category"
                        type="text"
                        v-model="sale.category"
                      ></v-text-field>
                      <v-text-field
                        outlined
                        disabled
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="sale.quantities"
                      ></v-text-field>
                      <v-text-field
                        outlined
                        disabled
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="sale.price"
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <v-card class="mx-auto elevation-12 midcard Blured">
                  <v-card-text class="pa-12">
                    <v-form ref="reset" class="pb-16 px-7">
                      <v-container
                        class="cont"
                        d-flex
                        flex-column
                        flex-direction:
                        row
                      >
                        <h3>Choose sale to edit :</h3>
                        <v-select
                          class="pr-16 pl-1"
                          :items="sales"
                          solo
                          label=""
                          ref="reset"
                          v-model="sale.name"
                        ></v-select>
                      </v-container>
                      <v-text-field
                        name="Sales"
                        label="Sale"
                        type="text"
                        counter="20"
                        v-model="sale.name"
                      ></v-text-field>
                      <v-textarea
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="sale.description"
                      ></v-textarea>
                      <v-text-field
                        name="Category"
                        label="Category"
                        type="text"
                        counter="20"
                        v-model="sale.category"
                      ></v-text-field>
                      <v-text-field
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="sale.quantities"
                      ></v-text-field>
                      <v-text-field
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="sale.price"
                      ></v-text-field>
                    </v-form>
                    <v-btn color="success" class="mr-4" @click="editsaleInfo">
                      Edit
                    </v-btn>

                    <v-btn color="error" class="mr-4" @click="reset">
                      Cancel Edit
                    </v-btn>
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <!-- </v-tab-items> -->
            </v-tabs>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  components: {},

  data: () => ({
    Total: [],
    tab3: "",
    items: [],
    disabled: true,
    sale: {
      id: [],
      products: [
        {
          id: '',
          price: 10,
          quantity: 1,
        }
      ],
      name: "",
    },
    clients: [],
    sales: [],
    valid: false,
    products: [],
    productRules: [(v) => !!v || "Product is required"],
    Seller: "",
    sellerRules: [
      (v) => !!v || "Seller is required",
      (v) => (v && v.length <= 20) || "Seller Must be less than 20 characters",
    ],
    Client: "",
    clientRules: [(v) => !!v || "Client is required"],
    Quantities: "",
    quantitiesRules: [
      (v) => !!v || "Quantities is required",
      // (v) => (v && v <= this.product.quantities) || "Quantities Must be less than "+ this.product.quantities,
    ],
  }),
  watch: {
    length(val) {
      this.form = val - 1;
    },
  },
  mounted() {
    const self = this;

    self.getsaleInfo();
    self.getProductsInfo();
  },
  methods: {
    Totals() {
      this.Total + this.Total;
    },
    getProductsInfo() {
      const self = this;

      // products/fetch
      self.axios.get("products").then((res) => {
        self.products = res.data;
      });
    },

    // Addsale(){
    //   const self = this

    //   const info = {
    //     product_name: self.sales.product_name,
    //     client_name: self.sales.client_name,
    //     seller_name: self.sales.seller_name,
    //     quantities: self.sales.quantities,
    //     total: self.sales.total
    //   }
    //   self.axios.post('http://127.0.0.1:8083/sales/update', info).then((res) => {

    //   })
    // },
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.reset.reset();
    },
    reset2() {
      this.$refs.reset2.reset();
    },
    // addransaction() {
    //   const self = this
    //   const info =
    // }
    editsaleInfo() {
      // const self = this
      // const info = {
      //   id: self.sales.id,
      //   name: self.sales.name,
      //   description: self.sales.description,
      //   category: self.sales.category,
      //   quantities: self.sales.quantities,
      //   price: self.sales.price,
      //   creation_date: self.sales.creation_date,
      // }
      // self.axios.post('', info).then((res) => {
      // })
    },
    getsaleInfo() {
      // const self = this
      // self.axios.get('').then((res) => {
      //   self.sales = res.data
      // })
    },
    // sale: {
    //   id: Number,
    //   client_id: Number,
    //   products: [
    //    {
    //      id: Number,
    //      quantity: Number,
    //    }
    //   ],
    //   seller: String,
    // }
  },
};
</script>

<style >
.cont {
  max-width: 300px !important;
}
.backs {
  background-image: url("~@/assets/Sales.jpg");
  background-size: cover;
  width: 100%;
}
</style>