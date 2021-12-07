# Trainer Notes

## Resources

Share Drive (slides, forms, etc.): https://drive.google.com/drive/folders/0AGoeHHagdNaaUk9PVA

Trello: https://trello.com/b/K63dLV58/loanslah

## Exercises structure:

For each new workshop, `main` branch will be forked into a new repo and share with the participants.

Sample implementation of the exercises are organised into branches. After each session, we can push the corresponding branch to the new repo.

The exercise structure is as followed:
1. Exercise 1: Implement a new method providing the loan outstanding amount, straight-forward TDD, no mock, dependency required.
2. Exercise 2: Fix bug, leverage existing test setup to find the bug and apply TDD when fixing it.
3. Exercise 3: Implement new requirement for interest rate, require external dependencies. `exercise3-pre` branch should be provided to the participants before this exercise starts. This exercise requires the participants to apply TDD on an end-to-end flow, work with different layers of the application, use mocks, write integration tests and e2e tests. Due to its scope, it is broken down into a few small steps acting as checkpoints for our discussion:
   1. Part 1: Create new service class responsible for the new feature.
   2. Part 2: Extract existing interest rate logic from the model into the service class.
   3. Part 3: Introduce the external dependency into the service class.
   4. Exercise 3-e2e: Add e2e test for the new feature (using docker-compose and wiremock). `exercise3-e2e-pre` branch should be provided to the participants before this exercise starts.
4. Exercise 4: Implement new requirement for new loan type. Similar structure to exercise 3, but this exercise we focus more on different approaches to drive TDD, in particular the bottom up (inside-out, classical TDD, Chicago-style) vs the top down (outside-in, mockist TDD, London-styled):
   1. `exercise4-part*` branches follow the bottom-up approach.
   2. `exercise4-outsidein-part*` branches follow the top-down approach.
