const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const app = express();
const port = 3000; 

mongoose.connect('mongodb://localhost:27017/myDb', { useNewUrlParser: true, useUnifiedTopology: true });

const userSchema = new mongoose.Schema({
  firstName: String,
  lastName: String,
  streetName: String,
  streetNumber: String,
  state: String,
  city: String,
  zipCode: String,
  email: String,
  country: String,
  pobox: String,
  password: String,
  profile: String,
});

const UserModel = mongoose.model('User', userSchema);

app.use(bodyParser.json());

app.post('/add', async (req, res) => {
  try {
    const userData = req.body;

    const newUser = new UserModel(userData);

    await newUser.save();

    res.status(200).json({ message: 'User added successfully' });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Internal server error' });
  }
});

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
