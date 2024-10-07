# Utility Payments System

A demonstration project for processing utility payments, featuring users, payment addresses, templates, and payment processing with status polling.

## Entities

### User
- **Full Name**: (String)
- **Email**: Acts as the login identifier
- **Phone Number**: (String)

### User's Payment Address
- **Unique Identifier**: (UUID)
- **Address String**: String representation of the address
- **Relationship to User**: Each address is linked to a specific user  
  A single user can have multiple payment addresses.

### Template
- **Unique Identifier**: (UUID)
- **Template Name**: (String)
- **IBAN**: (String)
- **Payment Purpose**: Description of the purpose of the payment
- **Relationship to Address**: A template is linked to a user's payment address  
  Each payment address may have multiple templates.

### Payment
- **Unique Identifier**: (UUID)
- **Template**: Reference to the template being used for payment
- **Card Number**: String for the payment card number
- **Amount**: Decimal value for the payment amount
- **Status**: Enum: `New`, `Paid`, `Failed`
- **Creation Timestamp**: DateTime of payment creation
- **Status Update Timestamp**: DateTime of the last status change

All entities are reflected in the database schema.

---

## Payment Process

1. **Create a New Payment**  
   When a payment is initiated, its status is set to `"New"`.

2. **Status Polling in a Separate Thread**  
   A separate thread fetches payments with the status `"New"` every second.

3. **Status Check Logic**  
   - For the first two seconds, the payment status remains `"New"`.
   - After the second second, the status is randomly determined with equal probability among all three possible statuses: `New`, `Paid`, and `Failed`.

---

## Demonstration Program Flow

1. **Register a User**  
   Create a new user with their full details.

2. **Add Two Payment Addresses**  
   Register two separate payment addresses for this user.

3. **Create Templates for Each Address**  
   Create 1-2 templates for each payment address.

4. **Initiate Multiple Payments**  
   Generate several payments using the templates.

5. **Await Final Status**  
   Monitor the payments until each reaches its final status (`Paid` or `Failed`).

This flow simulates a user registering, setting up payment addresses, defining payment templates, and processing payments with real-time status updates.

---

## Technologies Used
- Java (JDK 8 or above)
- Database: [Your DB choice here, e.g., PostgreSQL]
- Frameworks: [Specify any frameworks, e.g., Spring Boot]

---

## Running the Project
1. Clone the repository.
2. Set up your database connection.
3. Run the application.
4. Follow the demonstration flow to test the system.

---
