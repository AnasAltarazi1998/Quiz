<template>
  <div class="backp fill-height">
    <v-container justify-center fluid fill-height>
      <v-row justify="center">
        <v-col cols="6">
          <h1 class="text-center pb-2">Welcome to Products Management page</h1>
          <v-divider></v-divider>
          <v-card>
            <v-tabs
              color="deep-purple accent-4"
              background-color="primary"
              left
              v-model="tab2"
            >
              <v-tab class="white--text">Create New Product</v-tab>
              <v-tab class="white--text">View Products</v-tab>
              <v-tab class="white--text">Edit existing product</v-tab>
              <!-- <v-tabs-items v-model="tab2"> -->
              <v-tab-item>
                <!-- v-for="(item, i) in items" :key="i" :value="tab2[0]"  this must be with* <v-tab-item * > one line above >-->
                <v-card class="mx-auto elevation-12">
                  <v-card-text>
                    <v-form
                      v-model="valid"
                      lazy-validation
                      ref="form"
                      class="py-10 px-7"
                    >
                      <h3>Have a new Product ? Add it</h3>
                      <v-text-field
                        name="Productname"
                        label="Product Name"
                        type="text"
                        counter="20"
                        v-model="tabs[0].product.name"
                        :rules="productnameRules"
                        required
                      ></v-text-field>
                      <v-textarea
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="tabs[0].product.description"
                        :rules="descriptionRules"
                        required
                      ></v-textarea>
                      <v-text-field
                        name="Category"
                        label="Category"
                        type="text"
                        counter="20"
                        v-model="tabs[0].product.category"
                        :rules="categoryRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="tabs[0].product.quantities"
                        :rules="quantitiesRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="tabs[0].product.price"
                        :rules="priceRules"
                        required
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column">
                    <v-spacer></v-spacer>
                    <v-btn
                      :disabled="!valid"
                      class="mr-4"
                      @click="validate, createProductInfo"
                      color="primary"
                    >
                      Create
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <!-- v-for="(item, i) in items" :key="i" :value="tab2[1]" this must be with* <v-tab-item  * > one line above-->
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
                        <h3>Choose Product to view :</h3>
                        <v-select
                          class="pr-16 pl-1"
                          :items="products"
                          item-text="title"
                          item-value="id"
                          solo
                          label=""
                          ref="reset"
                          v-model="tabs[1].product.id"
                        ></v-select>
                        <p>Product id {{ tabs[1].product.id }}</p>
                      </v-container>
                      <v-text-field
                        outlined
                        readonly
                        name="Productname"
                        label="Product Name"
                        type="text"
                        v-model="tabs[1].product.name"
                      ></v-text-field>
                      <v-textarea
                        outlined
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="tabs[1].product.description"
                        readonly
                      ></v-textarea>
                      <v-text-field
                        outlined
                        readonly
                        name="Category"
                        label="Category"
                        type="text"
                        v-model="tabs[1].product.category"
                      ></v-text-field>
                      <v-text-field
                        outlined
                        readonly
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="tabs[1].product.quantities"
                      ></v-text-field>
                      <v-text-field
                        outlined
                        readonly
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="tabs[1].product.price"
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <!-- v-for="(item, i) in items" :key="i" :value="tab2[2]"  this must be with* <v-tab-item  * > one line above -->
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
                        <h3>Choose Product to edit :</h3>
                        <v-select
                          class="pr-16 pl-1"
                          :items="products"
                          solo
                          label=""
                          ref="reset"
                          v-model="tabs[2].product.name"
                        ></v-select>
                      </v-container>
                      <v-text-field
                        name="Productname"
                        label="Product Name"
                        type="text"
                        counter="20"
                        v-model="tabs[2].product.name"
                      ></v-text-field>
                      <v-textarea
                        label="Description"
                        rows="1"
                        type="text"
                        v-model="tabs[2].product.description"
                      ></v-textarea>
                      <v-text-field
                        name="Category"
                        label="Category"
                        type="text"
                        counter="20"
                        v-model="tabs[2].product.category"
                      ></v-text-field>
                      <v-text-field
                        name="QuantitiesInStock"
                        label="Quantities in Stock"
                        type="number"
                        v-model="tabs[2].product.quantities"
                      ></v-text-field>
                      <v-text-field
                        name="PricePerPiece"
                        label="Price Per Piece"
                        type="number"
                        v-model="tabs[2].product.price"
                      ></v-text-field>
                    </v-form>
                    <v-btn
                      color="success"
                      class="mr-4"
                      @click="editProductInfo"
                    >
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
              <!-- </v-tabs-items> -->
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
    tab2: "",
    items: [],
    disabled: true,
    products: [],
    tabs: [
      {
        product: {}
      },
      {
        product: {}
      },
      {
        product: {}
      },
    ],
    valid: false,
    Productname: [],
    productnameRules: [
      (v) => !!v || "Product name is required",
      (v) =>
        (v && v.length <= 20) || "Product name must be less than 20 characters",
    ],
    Description: "",
    descriptionRules: [
      (v) => !!v || "Description is required",
      (v) =>
        (v && v.length <= 100) ||
        "Description Must be less than 100 characters",
    ],
    Category: "",
    categoryRules: [
      (v) => !!v || "Category is required",
      (v) =>
        (v && v.length <= 20) || "Category Must be less than 20 characters",
    ],
    QuantitiesInStock: "",
    quantitiesRules: [
      (v) => !!v || "Quantities is required",
      (v) =>
        (v && v >= 0 && v <= 10000) || "Quantities Must be less than 10,000",
    ],
    PricePerPiece: "",
    priceRules: [
      (v) => !!v || "Price is required",
      (v) => (v && v >= 0 && v <= 10000) || "Price Must be less than 10,000",
    ],
  }),
  mounted() {
    const self = this;

    self.getProductsInfo();
  },
  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.reset.reset();
    },
    reset2() {
      this.$refs.reset2.reset();
    },
    createProductInfo () {
      const self = this

      const info = {
        id: self.tabs[0].product.id,
        name: self.tabs[0].product.name,
        description: self.tabs[0].product.description,
        category: self.tabs[0].product.category,
        quantities: self.tabs[0].product.quantities,
        price: self.tabs[0].product.price,
        creation_date: self.tabs[0].product.creation_date,
      }

      self.axios.post('http://127.0.0.1:8083/products/create', info).then(() => {

      })
    },
    editProductInfo () {
      const self = this

      const info = {
        id: self.product.id,
        name: self.product.name,
        description: self.product.description,
        category: self.product.category,
        quantities: self.product.quantities,
        price: self.product.price,
        creation_date: self.product.creation_date,
      }

      self.axios.post('http://127.0.0.1:8083/products/update', info).then(() => {

      })
    },
    getProductsInfo () {
      const self = this

      // products/fetch
      self.axios.get('products').then((res) => {
        self.products = res.data
      })
    }
  },
};
</script>

<style >
.cont {
  max-width: 300px !important;
}
.backp {
  background-image: url("~@/assets/PMBackground.jpg");
  background-size: cover;
  width: 100%;
}
</style>
