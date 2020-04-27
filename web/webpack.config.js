let dev = require("./conf/webpack.config.dev")
let prod = require("./conf/webpack.config.prod")

module.exports = env => {

    console.log('NODE_ENV: ', env.NODE_ENV);

    if (env.NODE_ENV == 'dev') {
        return dev
    } else {
        return prod
    }

}
