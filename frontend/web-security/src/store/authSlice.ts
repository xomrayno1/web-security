import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from "@reduxjs/toolkit";

export interface User {
  username: string;
  email: string;
}

export interface AuthState {
  user: User | null;
  isCompleted: boolean;
}

const initialState: AuthState = {
  user: null,
  isCompleted: false
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    loginSuccess: (state, action: PayloadAction<AuthState>) => {
      state.user = action.payload.user
      state.isCompleted = action.payload.isCompleted
    },
    logout: (state) => {
      state.user = null;
      state.isCompleted = false
    },
  },
});

export const { loginSuccess, logout } = authSlice.actions;
export default authSlice.reducer;
