# Ebanx API

> ✳️ this API was built as part of the process for the company **Ebanx**

## routes:
| route | description |
|-------|-------------|
| `/events` | handle account-related events: create account, deposit, withdraw, transfer |
| `/balance?account_id=123` | return the current balance of the account |
| `/reset` | delete all accounts (reset state) | 

## stack:
- **Language:** Java
- **Framework:** Spring Boot Web, Spring Boot Validation

## tests:

### `/reset`
- [X]  reset state before starting tests

### `/balance`
- [X]  get balance for existing account
- [X]  get balance for non-existing account

### `/events`
- [X] create account with initial balance
- [X] deposit into existing account
- [X] withdraw from existing account
- [X] withdraw from non-existing account
- [X] transfer from existing account
- [X] transfer from non-existing account
