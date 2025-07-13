import express from 'express';
import {

getProducts,
getProductById,
createProduct,
updateProduct,
deleteProduct,
} from '../controllers/data/productHandling';

const router = express.Router();

router.get('/', async (req, res) => { await getProducts(req, res).catch(error => { console.error(error); res.status(500).send('Internal Server Error'); }); });

router.get('/:id', async (req, res) => { await getProductById(req, res).catch(error => { console.error(error); res.status(500).send('Internal Server Error'); }); });

router.post('/', async (req, res) => { await createProduct(req, res).catch(error => { console.error(error); res.status(500).send('Internal Server Error'); }); });

router.put('/:id', async (req, res) => { await updateProduct(req, res).catch(error => { console.error(error); res.status(500).send('Internal Server Error'); }); });

router.delete('/:id', async (req, res) => { await deleteProduct(req, res).catch(error => { console.error(error); res.status(500).send('Internal Server Error'); }); });

export default router;