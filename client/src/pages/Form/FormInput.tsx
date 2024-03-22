import React, { useState, ChangeEvent, FormEvent } from 'react';
import Swal from 'sweetalert2';
import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import { tambahData } from '../../Axios/Axios';
import { useNavigate } from 'react-router-dom';
const FormInput = () => {
  const [formData, setFormData] = useState({
    namaBarang: '',
    kategori: '',
    satuan: 0,
    harga: 0,
  });

  const navigation = useNavigate();

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: name === 'satuan' ? parseInt(value) : value, // Convert satuan to number type
    }));
  };

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      await tambahData(formData);
      // Optionally, you can redirect the user or show a success message here
      Swal.fire({
        icon: 'success',
        title: 'Success!',
        text: 'Data added successfully!',
      });
      // Optionally, you can reset the form data after submission
      setFormData({
        namaBarang: '',
        kategori: '',
        satuan: 0,
        harga: 0,
      });

      navigation('/tables');
    } catch (error) {
      console.error('Error adding data:', error);
      // Handle error, show error message, etc.
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error adding data. Please try again later.',
      });
    }
  };

  return (
    <DefaultLayout>
      <Breadcrumb pageName="Form Input" />

      <div className="grid grid-cols-1 gap-9 sm:grid-cols-2">
        <div className="flex flex-col gap-9">
          {/* <!-- Input Fields --> */}
          <form onSubmit={handleSubmit}>
            <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
              <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
                <h3 className="font-medium text-black dark:text-white">
                  Input Barang
                </h3>
              </div>
              <div className="flex flex-col gap-5.5 p-6.5">
                <div>
                  <label
                    htmlFor="namaBarang"
                    className="mb-3 block text-black dark:text-white"
                  >
                    Nama Barang
                  </label>
                  <input
                    type="text"
                    id="namaBarang"
                    name="namaBarang"
                    value={formData.namaBarang}
                    onChange={handleChange}
                    placeholder="Nama Barang"
                    className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                  />
                </div>

                <div>
                  <label
                    htmlFor="kategori"
                    className="mb-3 block text-black dark:text-white"
                  >
                    Kategori
                  </label>
                  <input
                    type="text"
                    id="kategori"
                    name="kategori"
                    value={formData.kategori}
                    onChange={handleChange}
                    placeholder="Kategori"
                    className="w-full rounded-lg border-[1.5px] border-primary bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:bg-form-input dark:text-white"
                  />
                </div>
                <div>
                  <label
                    htmlFor="satuan"
                    className="mb-3 block text-black dark:text-white"
                  >
                    Jumlah
                  </label>
                  <input
                    type="number" // Change input type to number
                    id="satuan"
                    name="satuan"
                    value={formData.satuan}
                    onChange={handleChange}
                    placeholder="Jumlah"
                    className="w-full rounded-lg border-[1.5px] border-primary bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:bg-form-input dark:text-white"
                  />
                </div>
                <div>
                  <label
                    htmlFor="harga"
                    className="mb-3 block text-black dark:text-white"
                  >
                    Harga
                  </label>
                  <input
                    type="text"
                    id="harga"
                    name="harga"
                    value={formData.harga}
                    onChange={handleChange}
                    placeholder="Harga"
                    className="w-full rounded-lg border-[1.5px] border-primary bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:bg-form-input dark:text-white"
                  />
                </div>
                <button
                  type="submit"
                  className="flex w-full justify-center rounded bg-primary p-3 font-medium text-gray hover:bg-opacity-90"
                >
                  Tambah
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </DefaultLayout>
  );
};

export default FormInput;
