<template>
<div class="backs fill-height">
    <v-container justify-center fluid fill-height>
      <v-row justify="center">
      <v-col cols="6" >
  <h1 class="text-center pb-2"> Welcome to Sales Management page  </h1>    
  <v-divider  ></v-divider>
  <v-card>
            <v-tabs
              color="deep-purple accent-4"
              background-color="primary"
              left
              v-model="tab"
            >
              <v-tab class="white--text">Create New Sale</v-tab>
              <v-tab class="white--text">View Sales</v-tab>
              <v-tab class="white--text">Edit Sales</v-tab>
              <v-tab-item>
                <v-card class="mx-auto elevation-12  ">
                  <v-card-text >
                    <v-form
                      v-model="valid"
                      lazy-validation
                      ref="form"
                      class="py-10 px-7"
                    >
                  <h3>Let's sale something </h3>
                      <v-select class="pr-16 pl-1 "
                          :items="Products"
                          item-text="name"
                          item-value="name"
                          solo
                          label="Product name"
                          ref="reset"
                          v-model="tabs[0].sale.product_name"
                        ></v-select>
                        <v-row>
                        <v-col cols="2">
                        <v-text-field
                        outlined
                        readonly
                        name="Price"
                        label="Price"
                        type="number"
                        v-model="tabs[0].product.price"
                      ></v-text-field>
                      </v-col>
                        <v-col cols="3">
                      <v-text-field
                        outlined
                        name="Quantities"
                        label="Quantities"
                        type="number"
                        v-model="tabs[0].sale.quantities"
                        required
                      ></v-text-field> 
                      </v-col>
                      </v-row>
                      <v-select class="pr-16 pl-1 "
                          :items="Clients"
                          item-text="name"
                          item-value="name"
                          solo
                          label="Client name"
                          ref="reset"
                          v-model="tabs[0].sale.client_name"
                        ></v-select>
                        <v-row>
                      <v-col cols="2">
                      <v-text-field
                       outlined 
                       :value="tabs[0].sale.quantities * tabs[0].product.price"
                        name="total"
                        label="Total"
                        type="number"
                        v-model="tabs[0].sale.total"
                        readonly
                      ></v-text-field>
                      </v-col>
                      <v-col cols="3">
                      <v-text-field
                        outlined 
                        name="Seller"
                        label="Seller"
                        type="text"
                        v-model="tabs[0].sale.saller_name"
                        readonly
                      ></v-text-field>
                      </v-col>
                      </v-row>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column">
                    <v-spacer></v-spacer>
                    <v-btn 
                      :disabled="!valid"
                      class="mr-4 "
                      @click="createSale"
                      color="primary"
                     >
                     Sell
                     </v-btn>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item>
                <v-card class="mx-auto elevation-12 midcard Blured" >
                  <v-card-text class="pa-12" >
                    <v-form 
                    ref="reset"
                      class="pb-16 px-7"
                    >
                    <v-container class="cont " d-flex flex-column flex-direction: row >
                      <h3>Choose sale to view :</h3>
                      <v-select class="pr-16 pl-1 " 
                          :items="Sales"
                          item-text="id"
                          item-value="id"
                          solo
                          label=""
                          ref="reset"
                          v-model="tabs[1].sale.id"
                          
                        ></v-select>
                        <p>sale id  {{tabs[1].sale.id}}</p>
                    </v-container >
                      <v-text-field 
                          readonly
                          solo
                          label="Product name"
                          ref="reset"
                          v-model="tabs[1].sale.product_name"
                        ></v-text-field>
                        <v-row>
                        <v-col cols="3">
                        <v-text-field
                        readonly
                        solo
                        name="Price"
                        label="Price"
                        type="number"
                        v-model="tabs[1].product.price"
                      ></v-text-field>
                      </v-col>
                      <v-col cols="3">
                      <v-text-field
                        solo
                        name="Quantities"
                        label="Quantities"
                        type="number"
                        readonly
                        v-model="tabs[1].sale.quantities"
                      ></v-text-field> 
                      </v-col>
                      </v-row>
                      <v-text-field 
                          readonly
                          solo
                          label="Client name"
                          ref="reset"
                          v-model="tabs[1].sale.client_name"
                        ></v-text-field>
                      <v-col cols="2">
                      <v-text-field
                        solo
                        name="total"
                        label="Total"
                        type="number"
                        readonly
                        v-model="tabs[1].sale.total"
                      ></v-text-field>
                      </v-col>
                    </v-form>
                    
                  </v-card-text>
                  <v-card-actions class="flex-column pt-0">
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-tab-item>
              <v-tab-item >
                <v-card class="mx-auto elevation-12 midcard Blured" >
                  <v-card-text class="pa-12" >
                    <v-form 
                    ref="reset"
                      class="pb-16 px-7"
                    >
                    <v-container class="cont " d-flex flex-column flex-direction: row >
                      <h3>Choose sale to edit :</h3>
                      <v-select class="pr-16 pl-1 " 
                          :items="Sales"
                          item-text="id"
                          item-value="id"
                          solo
                          label=""
                          ref="reset"
                          v-model="tabs[2].sale.id"
                          
                        ></v-select>
                        <p>sale id  {{tabs[2].sale.id}}</p>
                    </v-container >
                      <v-text-field 
                          disabled
                          readonly
                          solo
                          label="Product name"
                          type="text"
                          v-model="tabs[2].sale.product_name"
                        ></v-text-field>
                        <v-row>
                        <v-col cols="3">
                        <v-text-field
                        disabled
                        readonly
                        solo
                        name="Price"
                        label="Price"
                        type="number"
                        v-model="tabs[2].product.price"
                      ></v-text-field>
                      </v-col>
                      <v-col cols="3">
                      <v-text-field
                        solo
                        name="Quantities"
                        label="Quantities"
                        type="number"
                        v-model="tabs[2].sale.quantities"
                      ></v-text-field> 
                      </v-col>
                      </v-row>
                      <v-text-field 
                          disabled
                          readonly
                          solo
                          label="Client name"
                          ref="reset"
                          v-model="tabs[2].sale.client_name"
                        ></v-text-field>
                      <v-col cols="2">
                      <v-text-field
                        :value="tabs[2].sale.quantities * tabs[2].product.price"
                        disabled
                        solo
                        name="total"
                        label="Total"
                        type="number"
                        readonly
                        v-model="tabs[2].sale.total"
                      ></v-text-field>
                      </v-col>
                    </v-form>
                    <v-btn
                      color="success"
                      class="mr-4"
                      @click="editsaleInfo"
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
            </v-tabs>
          </v-card>
      </v-col >
       </v-row>
       </v-container>
 
  </div>
</template>

<script>
export default {
  components: {},

  data: () => ({
    tab:'',
    items:[],
    disabled:true,
      Sales: [],
      Clients:[],
      Products:[],
    tabs:[
      {
        client:{},
        sale:{},
        product:{},
      },
      {
        client:{},
        product:{},
        sale:{},
      },
      {
        client:{},
        product:{},
        sale:{},
      },

    ],
    valid: false,
  }),
   mounted () {
    const self = this

    self.getsaleInfo()
  },
  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.reset.reset();
    },
    createSale() {
      const self = this;
      this.validate();
      const info = {
      product_name: self.tab[0].sale.product_name,
      client_name: self.tab[0].sale.client_name,
      quantities: self.tab[0].sale.quantities,
      saller_name: self.tab[0].sale.saller_name,
      total: self.tab[0].sale.total,
      };
      self.axios.post("http://127.0.0.1:8083/sales/sale", info).then();
    },
    editsaleInfo () {
      const self = this

      const info = {
        quantities:   self.tab[2].sale.quantities,
        total: self.tab[2].sale.total,
      }

      self.axios.post("http://127.0.0.1:8083/sales/update", info).then(() => {
        
      })
    },
    getsaleInfo () {
      const self = this

      self.axios.get("http://127.0.0.1:8083/sales/fetch").then((res) => {
        self.Sales = res.data
      })
    },
    getproductInfo () {
      const self = this

      self.axios.get("http://127.0.0.1:8083/products/fetch").then((res) => {
        self.Products = res.data
      })
    },
    getclientInfo () {
      const self = this

      self.axios.get("http://127.0.0.1:8083/clients/fetch").then((res) => {
        self.Clients = res.data
      })
    }
  },
}
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