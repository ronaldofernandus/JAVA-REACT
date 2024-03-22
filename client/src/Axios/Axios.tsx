import axios, { AxiosResponse } from 'axios';

const URL = 'http://localhost:8383/barang';

interface Barang {
  barangId?: number; // Optional for POST requests, as it will be generated by the server
  namaBarang: string;
  kategori: string;
  satuan: number;
  harga: number;
}

const listBarang = async (): Promise<Barang[]> => {
  try {
    const response: AxiosResponse<Barang[]> = await axios.get(URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw error;
  }
};

const tambahData = async (data: Barang): Promise<void> => {
  try {
    await axios.post(URL, data);
  } catch (error) {
    console.error('Error adding data:', error);
    throw error;
  }
};

const editData = async (namaBarang: string, data: Barang): Promise<void> => {
  try {
    await axios.put(`${URL}/${namaBarang}`, data);
  } catch (error) {
    console.error('Error editing data:', error);
    throw error;
  }
};


const deleteData = async (namaBarang: string): Promise<void> => {
  try {
    await axios.delete(`${URL}/${namaBarang}`);
  } catch (error) {
    console.error('Error deleting data:', error);
    throw error;
  }
};


const findDataByNama = async (namaBarang: string): Promise<Barang | null> => {
  try {
    const response: AxiosResponse<Barang> = await axios.get(`${URL}/nama/${namaBarang}`);
    return response.data;
  } catch (error) {
    if (
      axios.isAxiosError(error) &&
      error.response &&
      error.response.status === 404
    ) {
      // If the response status is 404 (Not Found), return null as the data is not found
      return null;
    }
    console.error('Error fetching data by namaBarang:', error);
    throw error; // Rethrow the error for handling in the component
  }
};


export { listBarang, tambahData, editData, deleteData, findDataByNama };