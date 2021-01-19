<template>
<div class="backc fill-height">
    <v-container justify-center fluid fill-height>
      <v-row justify="center">
      <v-col cols="6" >
  <h1 class="text-center pb-2"> Welcome to Clients Management page  </h1>    
  <v-divider  ></v-divider>
  <v-card>
            <v-tabs
              color="deep-purple accent-4"
              background-color="primary"
              left
              v-model="tab"
            >
              <v-tab class="white--text">Create New Client</v-tab>
              <v-tab class="white--text">View Clients</v-tab>
              <v-tab class="white--text">Edit existing Clients</v-tab>
              <v-tab-item>
                <v-card class="mx-auto elevation-12  ">
                  <v-card-text >
                    <v-form
                      v-model="valid"
                      lazy-validation
                      ref="form"
                      class="py-10 px-7"
                    >
                  <h3>Add new Clients</h3>
                      <v-text-field
                        name="Clientname"
                        label="Client Name"
                        type="text"
                        counter="20"
                        v-model="tabs[0].client.name"
                        :rules="ClientnameRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        label="Last Name"
                        type="text"
                        v-model="tabs[0].client.last_name"
                        :rules="last_nameRules"
                        required
                      ></v-text-field>
                      <v-text-field
                        label="mobile"
                        type="number"
                        v-model="tabs[0].client.mobile"
                        :rules="mobileRules"
                        required
                      ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class="flex-column">
                    <v-spacer></v-spacer>
                    <v-btn 
                      :disabled="!valid"
                      class="mr-4 "
                      @click="createclientInfo"
                      color="primary"
                     >
                     Create
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
                      <h3>Choose client to view :</h3>
                      <v-select class="pr-16 pl-1 "
                          :items="clients"
                          item-text="name"
                          item-value="id"
                          solo
                          label=""
                          ref="reset"
                          
                          
                        ></v-select>
                         <p>Client id  {{tabs[1].client.id}}</p>
                    </v-container >
                      <v-text-field
                        outlined
                        readonly
                        name="Clientname"
                        label="Client Name"
                        type="text"
                        v-model="tabs[1].client.name"
                        
                      ></v-text-field>
                      <v-text-field
                        outlined
                        label="Last Name"
                        type="text"
                        v-model="tabs[1].client.last_name"
                        readonly
                     ></v-text-field>
                      <v-text-field
                        outlined
                        readonly
                        label="mobile"
                        type="text"
                        v-model="tabs[1].client.mobile"
                        
                      ></v-text-field>
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
                      <h3>Choose client to edit :</h3>
                      <v-select class="pr-16 pl-1 "
                          :items="clients"
                          item-text="name" 
                          solo
                          label=""
                          ref="reset"
                          
                          
                        ></v-select>
                    </v-container >
                      <v-text-field
                        name="Clientname"
                        label="Client Name"
                        type="text"
                        counter="20"
                        v-model="tabs[2].client.name"
                        
                      ></v-text-field>
                      <v-text-field
                        label="Last Name"
                        type="text"
                        v-model="tabs[2].client.last_name"
                     ></v-text-field>
                      <v-text-field
                        label="mobile"
                        type="text"
                        counter="20"
                        v-model="tabs[2].client.mobile"
                        
                      ></v-text-field>
                    </v-form>
                    <v-btn
                      color="success"
                      class="mr-4"
                      @click="editclientInfo"
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
    clients: [],
    tabs :[
      {
        client:{},
      },
      {
        client:{},
      },
      {
        client:{},
      },
    ],
      
    valid: false,
    Clientname: [],
    ClientnameRules: [
      (v) => !!v || "Client name is required",
      (v) => (v && v.length <= 20) || "Client name must be less than 20 characters",
    ],
    LastName: [],
    last_nameRules: [
      (v) => !!v || "LastName is required",
      (v) => (v && v.length <= 100) || "LastName Must be less than 100 characters",
    ],
    Mobile: "",
    mobileRules: [
      (v) => !!v || "Mobile is required",
      (v) => (v && v.length <= 15) || "Mobile Must be less than 20 characters",
    ],

  }),
   mounted () {
    const self = this

    self.getclientInfo()
  },
  methods: {
    validate() {
      this.$refs.form.validate();
    },
    reset() {
      this.$refs.reset.reset();
    },
    createclientInfo () {
      const self = this
      this.validate()
      const info = {
        id: self.client.id,
        name: self.client.name,
        last_name: self.client.last_name,
        mobile: self.client.mobile,
        
      }

      self.axios.post('http://127.0.0.1:8083/clients/create', info).then()
    },
    editclientInfo () {
      const self = this

      const info = {
        id: self.client.id,
        name: self.client.name,
        last_name: self.client.last_name,
        mobile: self.client.mobile,
      }

      self.axios.post('http://127.0.0.1:8083/clients/edit', info).then(() => {
        
      })
    },
    getclientInfo () {
      const self = this

      self.axios.get('http://127.0.0.1:8083/clients/fetch').then((res) => {
        self.clients = res.data
      })
    }
  },
}
</script>

<style >

.cont {
  max-width: 300px !important;
}
.backc {
  background-image: url("~@/assets/CLMBackground.jpg");
  background-size: cover;
  width: 100%;
}

</style>
