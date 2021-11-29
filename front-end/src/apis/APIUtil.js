import axios from './axios';

export async function createProduct(requestData) {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }

  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  const response = await axios.post('/product', requestData, {
    headers: header,
  });
  const data = await response.data;
  return data;
}

export async function getProducts() {
  let header = { 'Content-Type': 'application/json' };
  if (localStorage.getItem('accessToken')) {
    header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  }

  const response = await axios.get('/products', { headers: header });
  const data = await response.data;
  return data;
}

export async function getCurrentUser() {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }

  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;

  const response = await axios.get('/user/me', { headers: header });
  const data = await response.data;
  return data;
}

export async function addToCart(requestData) {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }

  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  const response = await axios.post('/cart', requestData, { headers: header });
  const data = await response.data;
  return data;
}

export async function getCart() {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }

  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  const response = await axios.get('/cart', { headers: header });
  const data = await response.data;
  return data;
}

export async function getConsumer() {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }

  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  const response = await axios.get('/consumer/11', { headers: header });
  const data = await response.data;
  return data;
}

export async function placeOrder(
  orderId,
  addressId,
  totalPrice,
  totalPriceWithDiscount
) {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }
  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  axios.patch(
    `/order/${orderId}`,

    {
      totalPrice: totalPrice,
      totalPriceWithDiscount: totalPriceWithDiscount,
      addressId: addressId,
      isAmountPaid: true,
      status: 'ORDER_PLACED',
    },

    { headers: header }
  );
}

export async function getOrders() {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }
  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;

  const response = await axios.get('/orders', { headers: header });
  const data = await response.data;
  return data;
}

export async function getFarmerInventory() {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }
  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;

  const response = await axios.get('/farmer-inventory', { headers: header });
  const data = await response.data;
  return data;
}

export async function getFarmerOrders() {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }
  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;

  const response = await axios.get('/farmer-orders', { headers: header });
  const data = await response.data;
  return data;
}

export async function addAddress(requestData) {
  if (!localStorage.getItem('accessToken')) {
    return Promise.reject('No access token set.');
  }

  let header = { 'Content-Type': 'application/json' };
  header['Authorization'] = `Bearer ${localStorage.getItem('accessToken')}`;
  const response = await axios.post('/address', requestData, {
    headers: header,
  });
  const data = await response.data;
  return data;
}
