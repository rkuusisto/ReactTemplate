const HtmlWebPackPlugin = require("html-webpack-plugin");
const UglifyJsPlugin = require("uglifyjs-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
//const OptimizeCSSAssetsPlugin = require("optimize-css-assets-webpack-plugin");
const {EnvironmentPlugin} = require("webpack");
const {DefinePlugin} = require("webpack")

var path = require('path');
var BUILD_DIR = path.resolve(__dirname, 'src/main/webapp');
var APP_DIR = path.resolve(__dirname, 'src/main/app');



const htmlWebpackPlugin = new HtmlWebPackPlugin({
    template: APP_DIR + '/index.html',
    filename: BUILD_DIR + "/index.html"
});

const uglifyJs = new UglifyJsPlugin( {
    uglifyOptions: {
        safari10: false,
        parallel: 4,
        sourcemap: false,
        comments: false,
        minimize: true,
        compress: {
          warnings: false,
          drop_debugger: false,
          dead_code: false,
          unused: false
        },
        output: {
          comments: false
        }       
      }
});

const envPlugin = new EnvironmentPlugin([
    'NODE_ENV'
]);


const definePlugin = new DefinePlugin({
    "process.env": {
        APIURL: JSON.stringify('http://localhost:8084/')
    },
    }
);

const miniCssExtractPlugin = new MiniCssExtractPlugin( {
      
      filename: "styles.css",
      chunkFilename: "styles.css"
});

module.exports = {
    entry: APP_DIR + '/index.js',
    output: {
        path: BUILD_DIR,
        filename: '[name].bundle.js',
        chunkFilename: '[name].bundle.js'
    },
    optimization: {
        splitChunks: {
        cacheGroups: {
            styles: {
                name: 'styles',
                test: /\.css$/,
                chunks: 'all',
                enforce: true
            }
        }
    }
    
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader'
                }
            },
            {
                test: /\.html$/,
                use: [
                    {
                        loader: 'html-loader'
                    }
                ]
            },
            {
                test: /\.css$/,
                use: [
                    {
                        loader: MiniCssExtractPlugin.loader,
                        options: {
                        }
                    },
                    {
                        loader: "css-loader",
                        options: {
                            importLoaders: 1,
                            sourceMap: false,
                            modules: false,
                            localIdentName: "[name]_[local]_[hash:base64]",
                            minimize: true
                        }
                    },
                    {
                        loader: "sass-loader",
                        options: {
                        }
                    }
                ]
            }
        ]
    },
    plugins: [htmlWebpackPlugin,uglifyJs,miniCssExtractPlugin,definePlugin]
}
