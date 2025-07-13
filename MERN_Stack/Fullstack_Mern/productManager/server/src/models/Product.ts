import { type Document, model, Schema } from 'mongoose'
import { type Product } from '../@types'
import { number } from 'joi'
interface I extends Document, Product {}

const instance = new Schema<I>(
  {
    /*
      document ID is set by default via MongoDB - the next line is deprecated!
    */

    title: {
      type: String,
      required: true,
    },
    description: {
      type: String,
      required: false,
    },
    price: {
      type: Number,
      required: true,
      default: 0,
    },
  },
  {
    timestamps: true,
  }
)

// NOTE! use a singular model name, mongoose automatically creates a collection like so:
// model: 'Account' === collection: 'accounts'
const modelName = 'Product'

export default model<I>(modelName, instance)
