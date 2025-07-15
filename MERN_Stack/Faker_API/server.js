const express = require("express");
const { faker } = require('@faker-js/faker');
const app = express();
const port = 8000;

// Middleware
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Function to create User
const createUser = () => {
    return {
        _id: faker.string.uuid(),
        firstName: faker.person.firstName(),
        lastName: faker.person.lastName(),
        phoneNumber: faker.phone.number(),
        email: faker.internet.email(),
        password: faker.internet.password()
    };
};

// Function to create Company
const createCompany = () => {
    return {
        _id: faker.string.uuid(),
        name: faker.company.name(),
        address: {
            street: faker.location.streetAddress(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            country: faker.location.country()
        }
    };
};

// API route to create a new user
app.get("/api/users/new", (req, res) => {
    const newUser = createUser();
    res.json(newUser);
});

// API route to create a new company
app.get("/api/companies/new", (req, res) => {
    const newCompany = createCompany();
    res.json(newCompany);
});

// API route to create both a user and a company
app.get("/api/user/company", (req, res) => {
    const newUser = createUser();
    const newCompany = createCompany();
    res.json({
        user: newUser,
        company: newCompany
    });
});

// Start the server
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
